import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./loginContainer.css";
import CustomAlert from "./CustomAlert";

function SignUpContainer() {
  const navigate = useNavigate();

  // State variables to hold form input
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const [emptyUsername, setUsernameStatus] = useState(false);
  const [emptyPassword, setPasswordStatus] = useState(false);
  const [userNotFound, setUserNotFoundStatus] = useState(false);

  const saveUserIDToLocalStorage = (id) => {
    if (id) {
      localStorage.setItem("customerId", JSON.stringify(id));
    }
  };

  // Handle form submission
  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault(); // prevent page reload
    setUsernameStatus(false);
    setPasswordStatus(false);
    setUserNotFoundStatus(false);

    if (name.trim() != "" && password.trim() != "") {
      try {
        const response = await fetch("http://localhost:8080/customer/Login", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            name: name,
            password: password,
          }),
        });
        const result = await response.json();
        if (response.ok && result[0] == "1") {
          // Login successful
          saveUserIDToLocalStorage(result[1]);
          navigate("/dashboard");
        } else if (result[0] == "0") {
          // Login failed
          setUserNotFoundStatus(true);
          setPassword("");
        } else if (result[0] == "2") {
          setUserNotFoundStatus(true);
          setPassword("");
        }
      } catch (error) {
        console.error("Login error:", error);
        alert("Server error. Please try later.");
      }
    } else if (name.trim() == "") {
      setUsernameStatus(true);
    } else if (password.trim() == "") {
      setPasswordStatus(true);
    }
  };

  const handleNavigate = () => {
    navigate("/signup");
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
        <h1>Login</h1>
        {userNotFound && (
          <CustomAlert alertText={"Username or password incorrect."} />
        )}
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
            <CustomAlert alertText="Username cannot be empty" />
          )}
        </form>
      </div>
      <div className="input_divs">
        <form onSubmit={handleLogin}>
          <div style={{ marginBottom: "10px", gridRow: 3 }}>
            <input
              type="password"
              className="input_boxes"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          {emptyPassword && (
            <CustomAlert alertText="Password cannot be empty" />
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
          New Here? Make an Account.
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
          Login
        </button>
      </div>
    </div>
  );
}

export default SignUpContainer;
