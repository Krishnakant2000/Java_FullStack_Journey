import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios from "axios";
import { useState } from "react";

function StudentForm() {
    const [student, setStudent] = useState({
        name: '',
        age: '',
        grade: ''
    });

    const queryClient = useQueryClient();

    // 1. Define the Mutation (The POST request)
    const mutation = useMutation({
        mutationFn: (newStudent) => {
            return axios.post('http://localhost:8080/api/students', newStudent);
        },
        onSuccess: () => {
            // 2. Refresh the list automatically after success!
            queryClient.invalidateQueries({ queryKey: ['students'] });
            setStudent({ name: '', age: '', grade: '' }); // Clear form
            alert('Student added successfully!');
        },
        onError: (error) => {
            alert("Error: " + error.response.data.error || "Something went wrong");
        }
    });


    const handleSubmit = (e) => {
        e.preventDefault();
        // Convert strings to numbers where needed before sending
        mutation.mutate({
            ...student,
            age: parseInt(student.age),
            grade: parseFloat(student.grade)
        });
    };

    return (
        <form onSubmit={handleSubmit} className="bg-white p-6 rounded-lg shadow-md mb-8">
            <h2 className="text-xl font-bold mb-4 text-gray-700">Add New Student</h2>
            <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
                <input
                    type="text"
                    placeholder="Name"
                    value={student.name}
                    onChange={(e) => setStudent({ ...student, name: e.target.value })}
                    className="border p-2 rounded"
                    required
                />
                <input
                    type="number"
                    placeholder="Age"
                    value={student.age}
                    onChange={(e) => setStudent({ ...student, age: e.target.value })}
                    className="border p-2 rounded"
                    required
                />
                <input
                    type="number"
                    placeholder="Grade"
                    value={student.grade}
                    onChange={(e) => setStudent({ ...student, grade: e.target.value })}
                    className="border p-2 rounded"
                    required
                />
            </div>
            <button
                type="submit"
                className="mt-4 bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 disabled:opacity-50"
                disabled={mutation.isPending}
            >
                {mutation.isPending ? 'Adding...' : 'Add Student'}
            </button>
        </form>
    );
}

export default StudentForm;