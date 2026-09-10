 import { useState, useEffect } from "react";
import axios from "axios";
import "./App.css";

function App() {

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [course, setCourse] = useState("");

  const [students, setStudents] = useState([]);

  const [editId, setEditId] = useState(null);


  // Get all students
  const getAllStudents = async () => {

    try {

      const response = await axios.get(
        "http://localhost:8080/api/v1/students"
      );

      setStudents(response.data.content);

    } catch (error) {

      console.log("Error fetching students");
      console.log(error);

    }

  };


  // Load students when page opens
  useEffect(() => {

    getAllStudents();

  }, []);


  // Edit student
  const handleEdit = (student) => {

    setEditId(student.id);
    setName(student.name);
    setEmail(student.email);
    setPhone(student.phone);
    setCourse(student.course);

  };


  // Delete student
  const handleDelete = async (id) => {

    const confirmDelete = window.confirm(
      "Are you sure you want to delete this student?"
    );

    if (!confirmDelete) {
      return;
    }

    try {

      await axios.delete(
        `http://localhost:8080/api/v1/students/${id}`
      );

      console.log("Student deleted successfully");

      getAllStudents();

    } catch (error) {

      console.log("Error deleting student");
      console.log(error);

    }

  };


  // Add or Update student
  const handleSubmit = async (e) => {

    e.preventDefault();

    const student = {
      name: name,
      email: email,
      phone: phone,
      course: course
    };

    try {

      // Add Student
      if (editId === null) {

        const response = await axios.post(
          "http://localhost:8080/api/v1/students",
          student
        );

        console.log("Student added successfully");
        console.log(response.data);

      }

      // Update Student
      else {

        const response = await axios.put(
          `http://localhost:8080/api/v1/students/${editId}`,
          student
        );

        console.log("Student updated successfully");
        console.log(response.data);

      }


      // Refresh student list
      getAllStudents();


      // Clear form
      setName("");
      setEmail("");
      setPhone("");
      setCourse("");
      setEditId(null);


    } catch (error) {

      console.log("Error adding/updating student");
      console.log(error);

    }

  };


  return (

    <div>

      <h1>Student Management System</h1>


      <h2>
        {editId === null ? "Add Student" : "Edit Student"}
      </h2>


      <form onSubmit={handleSubmit}>

        <div>

          <label>Name: </label>

          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />

        </div>


        <br />


        <div>

          <label>Email: </label>

          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />

        </div>


        <br />


        <div>

          <label>Phone: </label>

          <input
            type="text"
            value={phone}
            onChange={(e) => setPhone(e.target.value)}
          />

        </div>


        <br />


        <div>

          <label>Course: </label>

          <input
            type="text"
            value={course}
            onChange={(e) => setCourse(e.target.value)}
          />

        </div>


        <br />


        <button type="submit">

          {editId === null
            ? "Add Student"
            : "Update Student"}

        </button>


      </form>


      <h2>Student List</h2>


      <table border="1">

        <thead>

          <tr>

            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Course</th>
            <th>Action</th>

          </tr>

        </thead>


        <tbody>

          {students.map((student) => (

            <tr key={student.id}>

              <td>{student.id}</td>

              <td>{student.name}</td>

              <td>{student.email}</td>

              <td>{student.phone}</td>

              <td>{student.course}</td>

              <td>

                <button
                  onClick={() => handleEdit(student)}
                >
                  Edit
                </button>
               
                {" "}
                 
                <button
                  onClick={() => handleDelete(student.id)}
                >
                  Delete
                </button>

              </td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>

  );

}

export default App;
