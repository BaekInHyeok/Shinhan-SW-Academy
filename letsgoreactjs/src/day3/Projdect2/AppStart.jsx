import React, { useRef, useState } from "react";
import "./App.css";
import Header from "./Header";
import TodoEditor from "./TodoEditor";
import TodoList from "./TodoList";

const mockTodo = [
  {
    id: 0,
    isDone: false,
    content: "업무1",
    createdDate: new Date().getTime(),
  },
  {
    id: 1,
    isDone: false,
    content: "업무2",
    createdDate: new Date().getTime(),
  },
  {
    id: 2,
    isDone: false,
    content: "업무3",
    createdDate: new Date().getTime(),
  },
];

function AppStart(props) {
  const [todo, setTodo] = useState(mockTodo);

  const idRef = useRef(3);
  const onCreate = (content) => {
    const newItem = {
      id: idRef.current,
      content,
      isDone: false,
      createdDate: new Date().getTime(),
    };
    setTodo([newItem, ...todo]);
    idRef.current += 1;
  };

  const onUpdate = (targetId, coloumn, value) => {
    setTodo(
      todo.map((it) => {
        if (it.id === targetId) {
          return {
            ...it,
            isDone: !it.isDone,
          };
        } else {
          return it;
        }
      })
    );
  };

  const onDelete = (targetId) => {
    setTodo(todo.filter((it) => it.id !== targetId));
  };

  return (
    <div className="App">
      <Header />
      <TodoEditor onCreate={onCreate} />
      <TodoList todo={todo} onUpdate={onUpdate} onDelete={onDelete} />
    </div>
  );
}

export default AppStart;
