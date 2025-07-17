import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./loginContainer.css";
import CustomAlert from "./CustomAlert";

function SignUpContainer() {
  const navigate = useNavigate();

  // State variables to hold form input
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const [signupFailed, setSignupFailed] = useState(false);
  const [emptyUsername, setUsernameStatus] = useState(false);
  const [emptyPassword, setPasswordStatus] = useState(false);

  // Handle form submission
  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault(); // prevent page reload

    if (name.trim() != "" && password.trim() != "") {
      try {
        const response = await fetch(
          "http://localhost:8080/customer/createAccount",
          {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({
              name,
              password,
            }),
          }
        );

        const result = await response.json();

        if (response.ok && result == true) {
          // SignUp successful
          navigate("/dashboard");
        } else {
          // SignUp failed
          setSignupFailed(true);
        }
      } catch (error) {
        console.error("SignUp error:", error);
        alert("Server error. Please try later.");
      }
    } else if (name.trim() == "") {
      setUsernameStatus(true);
    } else if (password.trim() == "") {
      setPasswordStatus(true);
    }
  };

  const handleNavigate = () => {
    navigate("/");
  };

  return (
    <div className="login_outer_main">
      <div
        style={{
          gridColumn: "span 2",
          background: "transparent",
          padding: "5px",
          textAlign: "center",
          gridRow: 1,
        }}
      >
        <h1>SignUp</h1>
      </div>
      <div className="input_divs">
        <form onSubmit={handleLogin}>
          <div style={{ marginBottom: "10px", gridRow: 2 }}>
            <input
              type="text"
              className="input_boxes"
              placeholder="Username"
              value={name}
              onChange={(e) => setName(e.target.value)}
              required
            />
          </div>
          {emptyUsername && (
            <CustomAlert alertText="Username cannot be empty!" />
          )}
          {signupFailed && <CustomAlert alertText="Username already taken." />}
        </form>
      </div>
      <div className="input_divs">
        <form onSubmit={handleLogin}>
          <div style={{ marginBottom: "10px", gridRow: 3 }}>
            <input
              type="text"
              className="input_boxes"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          {emptyPassword && (
            <CustomAlert alertText="Password cannot be empty." />
          )}
        </form>
      </div>
      <div
        style={{
          textAlign: "center",
          gridRow: 5,
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <p id="choosing_link" onClick={handleNavigate}>
          Already have an account? Login
        </p>
      </div>
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          gridRow: 4,
        }}
      >
        <button onClick={handleLogin} className="log_button">
          SignUp
        </button>
      </div>
    </div>
  );
}

export default SignUpContainer;
