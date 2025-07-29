import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import CreditInput from "./creditInput";

function TransactionTab() {
  return (
    <Tabs defaultValue="account" className="w-[400px]">
      <TabsList className="bg-gray-900 rounded-2xl flex gap-1">
        <TabsTrigger
          value="account"
          className="text-yellow-200 px-4 py-1 !rounded-2xl border-1 border-transparent data-[state=active]:border-yellow-400 data-[state=active]:bg-gray-800 transition-all"
        >
          Credit
        </TabsTrigger>
        <TabsTrigger
          value="password"
          className="text-yellow-200 px-4 py-1 !rounded-full border-1 border-transparent data-[state=active]:border-yellow-400 data-[state=active]:bg-gray-800 transition-all"
        >
          Debit
        </TabsTrigger>
      </TabsList>
      <TabsContent className="h-[100%] w-[100%]" value="account">
        <CreditInput/>
      </TabsContent>
      <TabsContent value="password">Change your password here.</TabsContent>
    </Tabs>
  );
}

export default TransactionTab;
