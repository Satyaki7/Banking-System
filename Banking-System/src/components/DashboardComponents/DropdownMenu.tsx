import React, { useState } from "react";

interface DropdownOption {
  label: string;
  value: number;
}

interface DropdownMenuProps {
  label: string;
  options: DropdownOption[];
  onSelect: (value: number) => void;
}

const DropdownMenu: React.FC<DropdownMenuProps> = ({
  label,
  options,
  onSelect,
}) => {
  const [open, setOpen] = useState(false);
  const [selectedLabel, setSelectedLabel] = useState(label);

  const handleSelect = (option: DropdownOption) => {
    setSelectedLabel(option.label);
    setOpen(false);
    onSelect(option.value); // sending index or ID
  };

  return (
    <div style={{ gridColumn: 2 }}>
      <div
        className="dropdown-container"
        style={{ position: "relative", display: "inline-block" }}
      >
        <button
          onClick={() => setOpen(!open)}
          style={{
            padding: "8px",
            border: "1px solid #ccc",
            borderRadius: "4px",
            backgroundColor: "transparent",
          }}
        >
          {selectedLabel} ▼
        </button>
        {open && (
          <ul
            style={{
              position: "absolute",
              top: "100%",
              left: 0,
              listStyle: "none",
              margin: 0,
              padding: "4px",
              border: "1px dotted #ccc",
              borderRadius: "4px",
              background: "transparent",
              zIndex: 100,
            }}
          >
            {options.map((option) => (
              <li
                key={option.value}
                onClick={() => handleSelect(option)}
                style={{ padding: "6px", cursor: "pointer" }}
              >
                {option.label}
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
};

export default DropdownMenu;
