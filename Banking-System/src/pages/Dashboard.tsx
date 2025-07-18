import MoneyBox from "../components/DashboardComponents/MoneyBox";
import SideNavBar from "../components/SideNavBar";

const Dashboard: React.FC = () => {
  return (
    <div className="dashboard-body">
      <SideNavBar />
      <div className="dashboard-div-1">
        <div className="dashboard-subdiv" id="pocket">
          <MoneyBox headingText="Pocket" bodyText={"1000"} />
        </div>
        <div className="dashboard-subdiv" id="bank">
          <MoneyBox headingText="Bank" bodyText={"1000"} />
        </div>
        <div className="dashboard-subdiv" id="networth">
          <MoneyBox headingText="Net-worth" bodyText={"1000"} />
        </div>
      </div>
      <div className="dashboard-div-2">div2</div>
      <div className="dashboard-div-3">div3</div>
      <div className="dashboard-div-4">div4</div>
    </div>
  );
};

export default Dashboard;
