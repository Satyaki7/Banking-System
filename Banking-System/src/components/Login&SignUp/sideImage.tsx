import sideImg from "../../assets/side-image.jpg";
function SideImage() {
  return (
    <div
      style={{
        height: "100%",
        gridColumn: 1,
        overflow: "hidden",
        width: "100%",
        borderRadius: "20px"
      }}
    >
      <img
        src={sideImg}
        alt="A random image"
        style={{ width: "100%", height: "100%", objectFit: "cover" }}
      />
    </div>
  );
}

export default SideImage;
