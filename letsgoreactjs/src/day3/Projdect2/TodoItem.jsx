import React from "react";

const TodoItem = ({ id, content, isDone, createdDate, onUpdate, onDelete }) => {
  const onChangeCheckbox = () => {
    onUpdate(id);
  };

  const handleCheckBox = (e) => {
    onUpdate(id, e.target.name, e.target.value);
  };

  const onClickDelete = () => {
    onDelete(id);
  };
  return (
    <div className="TodoItem">
      <div className="checkbox_col">
        <input
          onChange={handleCheckBox}
          checked={isDone}
          name="isDone"
          type="checkbox"
        />
      </div>
      <div className="title_col">
        <input name="content" onChange={handleCheckBox} value={content}></input>
      </div>
      <div className="date_col">{new Date().toLocaleDateString()}</div>
      <div className="btn_col">
        <button onClick={onClickDelete}>삭제</button>
      </div>
    </div>
  );
};
export default TodoItem;
