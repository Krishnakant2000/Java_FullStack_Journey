import Student from './components/Student';
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';
import StudentForm from './components/StudentForm';

function App() {

  // 1. The useQuery Hook
  const { data: students, isLoading, isError, error } = useQuery({
    queryKey: ['students'], // A unique ID for this data
    queryFn: () =>
      // This calls your Spring Boot API
      axios.get('http://localhost:8080/api/students').then(res => res.data),
  });

  if (isLoading) return <h1 className="text-2xl font-bold text-center mt-10">Loading...</h1>;
  if (isError) return <h1 className="text-red-500 font-bold text-center mt-10">Error: {error.message}</h1>;

  return (
    <div className="p-10 min-h-screen bg-gray-100">
      <h1 className="text-3xl font-bold text-blue-600 mb-6 text-center">Student Management System</h1>

      <StudentForm />

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {/* We map over the REAL data now */}
        {students.map((student) => (
          <Student 
            key={student.id} 
            name={student.name} 
            age={student.age}      // Pass the real age
            grade={student.grade}  // Pass the real grade
          />
        ))}
      </div>
    </div>
  );
}

export default App;