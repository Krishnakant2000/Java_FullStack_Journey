import React from 'react';

// We now destructure specific props: name, age, grade
function Student({ name, age, grade }) {
  return (
    <div className="bg-white p-6 rounded-lg shadow-md border border-gray-200 hover:shadow-lg transition-shadow">
      <h3 className="text-xl font-bold text-gray-800 mb-2">{name}</h3>
      <div className="flex justify-between items-center text-sm text-gray-600">
        <p>Age: <span className="font-semibold text-black">{age}</span></p>
        <p>Grade: <span className="font-bold text-blue-600">{grade}%</span></p>
      </div>
    </div>
  );
}

export default Student;