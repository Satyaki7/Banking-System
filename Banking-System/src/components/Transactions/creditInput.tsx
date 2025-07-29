import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@radix-ui/react-select";
import DropdownMenu from "../DashboardComponents/DropdownMenu";

function CreditInput() {
  return (
    <div className="grid grid-rows-6 gap-1">
      <label className="row-start-1">Amount</label>
      <input className="row-start-2 border rounded px-2 py-1" type="text" />
      <label className="row-start-3">From</label>
      <select name="Hello" id=""></select>
      <label className="row-start-5">To</label>
    </div>
  );
}

export default CreditInput;
