type MoneyBoxProps = {
    headingText: string;
    bodyText: string;
}

function MoneyBox({headingText,bodyText}:MoneyBoxProps) {
    return (
      <div>
        <h2>
          <strong>{headingText}</strong>
        </h2>
        <h3>{bodyText}</h3>
      </div>
    );
}

export default MoneyBox;