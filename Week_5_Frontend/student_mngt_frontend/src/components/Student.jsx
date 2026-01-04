import React from 'react';

function Student({ id, name, age, grade, onDelete, onEdit }) {
  return (
    <div className="bg-white p-6 rounded-lg shadow-md border border-gray-200 flex flex-col justify-between">
      <div>
        <h3 className="text-xl font-bold text-gray-800 mb-2">{name}</h3>
        <div className="text-sm text-gray-600 space-y-1">
          <p>Age: <span className="font-semibold text-black">{age}</span></p>
          <p>Grade: <span className="font-bold text-blue-600">{grade}%</span></p>
        </div>
      </div>

      <div className="flex gap-2 mt-4 self-end">
        <button
          // Pass the full object back so we can populate the form
          onClick={() => onEdit({ id, name, age, grade })}
          className="bg-blue-100 text-blue-600 px-3 py-1 rounded text-sm hover:bg-blue-200 transition-colors font-medium"
        >
          Edit
        </button>

        <button
          onClick={() => onDelete(id)}
          className="bg-red-100 text-red-600 px-3 py-1 rounded text-sm hover:bg-red-200 transition-colors font-medium"
        >
          Delete
        </button>
      </div>
    </div>
  );
}

export default Student;