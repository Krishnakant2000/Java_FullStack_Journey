import { useState } from 'react';
import Student from './components/Student';

function App() {
  // Simulating data that will eventually come from your Java Backend
  const [students, setStudents] = useState([
    { id: 1, name: "Iron Man", role: "Tech Lead" },
    { id: 2, name: "Captain America", role: "Leader" },
    { id: 3, name: "Thor", role: "Security" }
  ]);

  return (
    <div style={{ padding: '20px' }}>
      <h1 className="text-3xl font-bold text-red-500 underline">Student List</h1>
      
      {/* The Magic Loop */}
      {students.map((student) => (
        <Student 
          key={student.id} // React needs a unique 'key' for performance
          name={student.name} 
          role={student.role} 
        />
      ))}
      
      <button onClick={() => setStudents([])}>
        Clear All
      </button>
    </div>
  );
}

export default App;