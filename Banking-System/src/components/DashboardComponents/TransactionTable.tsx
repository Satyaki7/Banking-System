import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

type Transaction = {
  source: string;
  amount: number;
  type: string;
  date: string;
  account: string; // ISO string like "2025-07-25"
};

type Props = {
  transactions: Transaction[];
};

function TransactionTable({ transactions }: Props) {
  return (
    <Table className="bg-amber-100">
      <TableCaption>A list of your recent transactions.</TableCaption>
      <TableHeader>
        <TableRow>
          <TableHead>Account</TableHead>
          <TableHead className="w-[120px]">Date</TableHead>
          <TableHead>Source</TableHead>
          <TableHead>Amount</TableHead>
          <TableHead className="text-center">Type</TableHead>
        </TableRow>
      </TableHeader>
      <TableBody>
        {transactions.map((tx, index) => (
          <TableRow key={index}>
            <TableCell>{tx.account}</TableCell>
            <TableCell>{new Date(tx.date).toLocaleDateString()}</TableCell>
            <TableCell>{tx.source}</TableCell>
            <TableCell>{tx.amount}</TableCell>
            <TableCell className="text-center">{tx.type}</TableCell>
          </TableRow>
        ))}
      </TableBody>
    </Table>
  );
}

export default TransactionTable;
