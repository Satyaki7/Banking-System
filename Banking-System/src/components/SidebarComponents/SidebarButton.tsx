type SidebarButtonProps = {
    buttonText: string;
}

function SidebarButton({buttonText}:SidebarButtonProps){
    return (
      <div className="sidebar-button-div">
        <button className="sidebar-button">{buttonText}</button>
      </div>
    );
}

export default SidebarButton