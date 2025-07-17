import LoginContainer from "../components/Login&SignUp/loginContainer";
import SideImage from "../components/Login&SignUp/sideImage";
import SignUpContainer from "../components/Login&SignUp/signupContainer";
import "../index.css";

const SignUp: React.FC = () => {
  return (
    <div className="login_page">
      <div className="login_page_inside">
        <SideImage />
        <SignUpContainer />
      </div>
    </div>
  );
};

export default SignUp;
