type CustomAlertProps = {
  alertText: string;
  type?: "success" | "danger" | "warning" | "info";
};

function CustomAlert({ alertText, type = "warning" }: CustomAlertProps) {
  return (
    <div
      className={`alert alert-${type} alert-dismissible fade show`}
      role="alert"
    >
      <strong>{alertText}</strong>
      <button
        type="button"
        className="btn-close"
        data-bs-dismiss="alert"
        aria-label="Close"
      ></button>
    </div>
  );
}

export default CustomAlert;
