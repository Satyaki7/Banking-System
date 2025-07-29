"use client";

import TransactionTable from "@/components/DashboardComponents/TransactionTable";
import DropdownMenu from "../components/DashboardComponents/DropdownMenu";
import MoneyBox from "../components/DashboardComponents/MoneyBox";
import "./pages.css";
import { useEffect, useState } from "react";
import { ScrollArea } from "@/components/ui/scroll-area";
import TransactionTab from "@/components/Transactions/transactionTab";

const Dashboard: React.FC = () => {
  const [storedId, setStoredId] = useState("");
  const [customerData, setCustomerData] = useState<any>(null);
  const [accountNumber, setAccountNumber] = useState(0);

  // ✅ Extracted fetch logic to reuse after account creation
  const fetchCustomerData = async () => {
    try {
      const customerIdStr = localStorage.getItem("customerId");
      const parsedId = customerIdStr ? JSON.parse(customerIdStr) : "";
      setStoredId(parsedId);

      const response = await fetch(
        "http://localhost:8080/customer/CustomerDetails",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ customerId: parsedId }),
        }
      );

      if (response.ok) {
        const data = await response.json();
        setCustomerData(data);
        setAccountNumber(0); // default to first account
      } else {
        console.error("Failed to fetch customer details");
      }
    } catch (error) {
      console.error("Error fetching customer data:", error);
    }
  };

  // 🔁 Initial fetch
  useEffect(() => {
    fetchCustomerData();
  }, []);

  // ✅ Create account and re-fetch data
  const handleCreateAccount = async () => {
    try {
      const response = await fetch(
        "http://localhost:8080/account/createAccount",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ customerId: storedId }),
        }
      );

      if (response.ok) {
        alert("Account created successfully!");
        await fetchCustomerData();
      } else {
        alert("Failed to create account.");
      }
    } catch (err) {
      console.error("Error creating account:", err);
    }
  };
  const transactions =
    customerData?.accounts?.flatMap((acc: any) => acc.transactions) || [];

  return (
    <div className="dashboard-body">
      <div className="dashboard-Overview">
        <div className="dashboard-div-1">
          {/* 🪙 Pocket Balance */}
          <div className="dashboard-subdiv" id="pocket">
            <MoneyBox
              headingText="Pocket"
              bodyText={
                customerData ? customerData.pocketBalance : "Loading..."
              }
            />
          </div>

          {/* 🏦 Bank Balance or Create Account */}
          <div className="dashboard-subdiv" id="bank">
            {customerData?.accounts?.length ? (
              <>
                <MoneyBox
                  headingText="Bank"
                  bodyText={
                    customerData.accounts[accountNumber]?.balance ??
                    "Loading..."
                  }
                />
                <DropdownMenu
                  accounts={customerData.accounts}
                  onSelect={setAccountNumber}
                  selectedIndex={accountNumber}
                />
              </>
            ) : (
              <button
                onClick={handleCreateAccount}
                className="create-account-btn"
              >
                Create Account
              </button>
            )}
          </div>

          {/* 💰 Net Worth (placeholder value for now) */}
          <div className="dashboard-subdiv" id="networth">
            <MoneyBox headingText="Net-worth" bodyText={"1000"} />
          </div>
        </div>

        <div className="dashboard-div-2">div2</div>
        <div className="dashboard-div-3">
          <TransactionTab />
        </div>
        <div
          className="dashboard-div-4"
          style={{
            background: "#333533",
            color: "whitesmoke",
            borderRadius: "16px",
            margin: "8px",
          }}
        >
          <ScrollArea className="w-[100%] h-[100%]">
            <TransactionTable transactions={transactions} />
          </ScrollArea>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
