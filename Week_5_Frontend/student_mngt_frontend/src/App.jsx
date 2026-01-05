import { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import axios from 'axios';
import Student from './components/Student';
import StudentForm from './components/StudentForm';
import Navbar from './components/Navbar';

function App() {
  const queryClient = useQueryClient();

  // STATE: Which student are we editing? (null = no one)
  const [editingStudent, setEditingStudent] = useState(null);

  const { data: students, isLoading, isError, error } = useQuery({
    queryKey: ['students'],
    queryFn: () => axios.get('http://localhost:8080/api/students').then((res) => res.data),
  });

  const deleteMutation = useMutation({
    mutationFn: (id) => axios.delete(`http://localhost:8080/api/students/${id}`),
    onSuccess: () => queryClient.invalidateQueries(['students']),
    onError: (error) => { alert("Error: " + (error.response?.data?.error || "Something went wrong")); }
  });

  // Handler for when Edit is clicked
  const handleDelete = (id) => {
    if (window.confirm("Delete this student?")) deleteMutation.mutate(id);
  };

  const handleEdit = (student) => {
    setEditingStudent(student); // Set the state
    window.scrollTo({ top: 0, behavior: 'smooth' }); // Scroll to form
  };

  if (isLoading) return <h1 className="text-center mt-10">Loading...</h1>;
  if (isError) return <h1 className="text-red-500 text-center">Error: {error.message}</h1>;

  return (
    <div className="min-h-screen bg-gray-100">
      <Navbar />
      <div className="max-w-6xl mx-auto px-4 pb-10">

        {/* Pass state to Form */}
        <StudentForm
          editingStudent={editingStudent}
          setEditingStudent={setEditingStudent}
        />

        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
          {students.map((student) => (
            <Student
              key={student.id}
              {...student} // Spread operator - Shortcut to pass all props (id, name, age, grade)
              onDelete={handleDelete}
              onEdit={handleEdit}
            />
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;