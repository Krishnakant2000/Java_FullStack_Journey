function Student(props) {
    
    return (
        
        <div style={{ border: '1px solid #ccc', padding: '10px', margin: '10px', borderRadius: '8px' }}>
            <h3>Name: {props.name}</h3>
            <p>Role: {props.role}</p>
            <p>Grade: {props.grade}</p>
        </div>
    );
}

export default Student;