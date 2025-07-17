
import LoginContainer from "../components/Login&SignUp/loginContainer";
import SideImage from "../components/Login&SignUp/sideImage";
import SignUpContainer from "../components/Login&SignUp/signupContainer";
import '../index.css';

const Login: React.FC = () => {
  
  return (
    <div className="login_page">
      <div className="login_page_inside">
        <SideImage />
        <LoginContainer />
      </div>
    </div>
  );
};

export default Login;
