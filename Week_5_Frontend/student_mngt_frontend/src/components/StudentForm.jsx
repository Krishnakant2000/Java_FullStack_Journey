import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios from "axios";
import { useEffect, useState } from "react";

function StudentForm({ editingStudent, setEditingStudent }) {
    const [student, setStudent] = useState({
        name: '',
        age: '',
        grade: ''
    });

    const queryClient = useQueryClient();

    useEffect(() => {
        if (editingStudent) {
            // If we clicked edit, fill the boxes
            setStudent(editingStudent);
        } else {
            // If we cleared edit, reset the form
            setStudent({ name: '', age: '', grade: '' });
        }
    }, [editingStudent]); // Run this whenever editingStudent changes

    // Define the Create Mutation (The POST request)
    const createMutation = useMutation({
        mutationFn: (newStudent) => axios.post('http://localhost:8080/api/students', newStudent),
        onSuccess: () => {
            queryClient.invalidateQueries(['students']);
            setStudent({ name: '', age: '', grade: '' });
            alert("Student Added Successfully!");
        },
        onError: (error) => {
            alert("Error: " + (error.response?.data?.error || "Something went wrong"));
        }
    });

    // Define the Update Mutation (The PUT request)
    const updateMutation = useMutation({
        mutationFn: (updatedStudent) => axios.put(`http://localhost:8080/api/students/${updatedStudent.id}`, updatedStudent),
        onSuccess: () => {
            queryClient.invalidateQueries(['students']);
            setEditingStudent(null); // Exit edit mode
            setStudent({ name: '', age: '', grade: '' });
            alert("Student Updated Successfully!");
        },
        onError: (error) => {
            alert("Error: " + (error.response?.data?.error || "Something went wrong"));
        }
    });


    const handleSubmit = (e) => {
        e.preventDefault();
        // Convert strings to numbers where needed before sending
        const studentData = {
            ...student,
            age: parseInt(student.age),
            grade: parseFloat(student.grade)
        };
        if (editingStudent) {
            // If we have an ID, we are updating
            updateMutation.mutate(studentData);
        } else {
            // Otherwise, we are creating
            createMutation.mutate(studentData);
        }
    };

    return (
        <form onSubmit={handleSubmit} className="bg-white p-6 rounded-lg shadow-md mb-8 border-t-4 border-blue-500">
            <div className="flex justify-between items-center mb-4">
                <h2 className="text-xl font-bold text-gray-700">
                    {editingStudent ? 'Edit Student' : 'Add New Student'}
                </h2>

                {/* CANCEL BUTTON (Only show when editing) */}
                {editingStudent && (
                    <button
                        type="button"
                        onClick={() => setEditingStudent(null)}
                        className="text-sm text-gray-500 hover:text-gray-700 underline"
                    >
                        Cancel Edit
                    </button>
                )}
            </div>

            <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
                <input
                    type="text" placeholder="Name" value={student.name}
                    onChange={(e) => setStudent({ ...student, name: e.target.value })}
                    className="border p-2 rounded focus:outline-none focus:ring-2 focus:ring-blue-400"
                    required
                />
                <input
                    type="number" placeholder="Age" value={student.age}
                    onChange={(e) => setStudent({ ...student, age: e.target.value })}
                    className="border p-2 rounded focus:outline-none focus:ring-2 focus:ring-blue-400"
                    required
                />
                <input
                    type="number" placeholder="Grade" value={student.grade}
                    onChange={(e) => setStudent({ ...student, grade: e.target.value })}
                    className="border p-2 rounded focus:outline-none focus:ring-2 focus:ring-blue-400"
                    required
                />
            </div>

            <button
                type="submit"
                className={`mt-4 px-4 py-2 rounded text-white transition-colors ${editingStudent ? 'bg-green-600 hover:bg-green-700' : 'bg-blue-600 hover:bg-blue-700'
                    }`}
            >
                {editingStudent ? 'Update Student' : 'Add Student'}
            </button>
        </form>
    );
}

export default StudentForm;