import React, { useEffect, useRef, useState } from "react";
import { Button } from "react-bootstrap";
import InputStudent from "day3/InputStudent";
import DisplayStudentList from "day3/DisplayStudentList";

const initMember = { mid: 1, name: "아무개", age: 10, email: "a@gmail.com" };
const initList = [
  initMember,
  { mid: 2, name: "Emmet", age: 27, email: "b@gmail.com" },
  { mid: 3, name: "JH", age: 29, email: "c@gmail.com" },
];
function UseRefTest3(props) {
  const [member, setMember] = useState({ initMember });
  const [memberList, setMemberList] = useState(initList);

  //DOM을 선택할 때 사용
  const nameInput1 = useRef(); //document.getElementByID("") 역할
  const nameInput2 = useRef();

  //다시 랜더링되어도 초기화되지 않는 변수가 필요
  const memberId = useRef(4); //4부터 시작
  const clickHandler1 = () => {
    nameInput1.current.focus();
  };
  const clickHandler2 = () => {
    nameInput2.current.focus();
  };
  const changeHandler = (e) => {
    setMember({ ...member, [e.target.name]: e.target.value });
  };
  const addHandler = () => {
    const newMember = { ...member, mid: memberId.current };
    setMember(newMember);
    memberId.current += 1; //다음번호
    setMemberList([...memberList, member]);
  };
  useEffect(() => {
    console.log(memberList);
  }, [memberList]);
  return (
    <div>
      <input ref={nameInput1} />
      <input ref={nameInput2} />
      <Button onClick={clickHandler1}>이동1</Button>
      <Button onClick={clickHandler2}>이동2</Button>
      <hr />
      <InputStudent student={member} changeHandler={changeHandler} />
      <Button onClick={addHandler}>Member 추가</Button>
      <DisplayStudentList studentList={memberList} />
    </div>
  );
}
export default UseRefTest3;
