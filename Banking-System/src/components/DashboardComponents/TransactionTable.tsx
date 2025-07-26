import {
  Table,
  TableBody,
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
    <Table
      className="rounded-2xl">
      <TableHeader>
        <TableRow className="text-lg">
          <TableHead style={{ color: "#FCF8C5" }}>Account</TableHead>
          <TableHead className="w-[120px]" style={{ color: "#FCF8C5" }}>
            Date
          </TableHead>
          <TableHead style={{ color: "#FCF8C5" }}>Source</TableHead>
          <TableHead style={{ color: "#FCF8C5" }}>Amount</TableHead>
          <TableHead className="text-center" style={{ color: "#FCF8C5" }}>
            Type
          </TableHead>
        </TableRow>
      </TableHeader>
      <TableBody className="text-base">
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
