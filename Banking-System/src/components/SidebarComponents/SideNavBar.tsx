import SidebarButton from "./SidebarButton";

function SideNavBar() {
  return (
    <div className="sidebar">
      <div id="sidebar-div-ad">
        <h2>Hello</h2>
      </div>
      <SidebarButton buttonText="Home" />
      <SidebarButton buttonText="Dashboard" />
      <SidebarButton buttonText="Play" />
      <SidebarButton buttonText="Transfer" />
      <div id="sidebar-div-settings">
        <h3>settings</h3>
      </div>
    </div>
  );
}

export default SideNavBar;
