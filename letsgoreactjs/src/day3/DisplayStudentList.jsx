import React from "react";
import { Card, ListGroup, Table } from "react-bootstrap";

function DisplayStudentList(props) {
  const { studentList } = props;
  return (
    <div>
      <h2>학생들의 목록</h2>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
          </tr>
        </thead>
        <tbody>
          {studentList.map((mem, seq) => (
            <tr key={seq}>
              <td>{mem.mid}</td>
              <td>{mem.name}</td>
              <td>{mem.email}</td>
              <td>{mem.age}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
}

export default DisplayStudentList;
