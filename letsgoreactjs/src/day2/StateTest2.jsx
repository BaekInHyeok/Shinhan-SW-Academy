import React, { useState } from "react";
import { Button, Form, InputGroup, Table } from "react-bootstrap";

function StateTest2(props) {
  const [member, setMember] = useState({ name: "아무개", age: 30 });
  const [memberList, setMemberList] = useState([]);

  const f1 = () => {
    var obj = { name: "아무개", age: 30 };
    obj["age"] = 40;

    obj.name2 = "신한";
    var name2 = "aa";
    obj[name2] = "신한aa";
    console.log(obj);
    var obj2 = { ...obj };
    console.log("obj2:", obj2);
  };
  f1();

  const onMemeberChangeHandler = (e) => {
    var newMember = { ...member, [e.target.name]: e.target.value }; //비동기처리
    setMember(newMember);
    console.log(
      "setMember 비동기 처리 되므로 setting하고 출력이 아님",
      newMember
    );
  };

  const addHandler = () => {
    setMemberList([...memberList, member]);
  };

  return (
    <div>
      <h1>이름과 나이를 입력</h1>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">이름</InputGroup.Text>
        <Form.Control
          name="name"
          defaultValue={member.name}
          onChange={onMemeberChangeHandler}
          placeholder="이름입력"
          aria-label="name"
          aria-describedby="basic-addon1"
        />
      </InputGroup>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">나이</InputGroup.Text>
        <Form.Control
          age="age"
          defaultValue={member.age}
          onChange={onMemeberChangeHandler}
          placeholder="나이입력"
          aria-label="age"
          aria-describedby="basic-addon1"
        />
      </InputGroup>
      <Button variant="success" onClick={addHandler}>
        멤버추가
      </Button>
      <hr />
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Name</th>
            <th>Age</th>
          </tr>
        </thead>
        <tbody>
          {memberList.map((mem, seq) => (
            <tr key={seq}>
              <td>{seq + 1}</td>
              <td>{mem.name}</td>
              <td>{mem.age}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
}

export default StateTest2;
