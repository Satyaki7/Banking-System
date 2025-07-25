import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import React from "react";

interface DropdownMenuProps {
  accounts: { balance: number }[];
  onSelect: (accountIndex: number) => void;
  selectedIndex: number;
}

const DropdownMenu: React.FC<DropdownMenuProps> = ({
  accounts,
  onSelect,
  selectedIndex,
}) => {
  return (
    <div className="">
      <Select
        value={String(selectedIndex)} // convert number to string
        onValueChange={(value) => onSelect(Number(value))} // convert string to number
      >
        <SelectTrigger
          className="border-amber-950"
          style={{ borderRadius: "16px" }}
        >
          <SelectValue placeholder="Select Account" />
        </SelectTrigger>
        <SelectContent className="bg-transparent">
          {accounts.map((_, index) => (
            <SelectItem
              key={index}
              value={String(index)}
              className="bg-transparent hover:bg-amber-50"
            >
              Account {index + 1}
            </SelectItem>
          ))}
        </SelectContent>
      </Select>
    </div>
  );
};

export default DropdownMenu;
