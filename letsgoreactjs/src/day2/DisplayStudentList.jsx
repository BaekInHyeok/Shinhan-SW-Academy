import React from "react";
import { Card, ListGroup } from "react-bootstrap";

function DisplayStudentList(props) {
  const { studnetList } = props;
  return (
    <div>
      <h2>학생들의 목록</h2>
      <Card style={{ width: "18rem" }}>
        <ListGroup variant="flush">
          {studnetList.map((item, index) => (
            <ListGroup.Item key={index}>
              {item.stdName} 학생의 전공은 {item.major}
            </ListGroup.Item>
          ))}
        </ListGroup>
      </Card>
    </div>
  );
}

export default DisplayStudentList;
