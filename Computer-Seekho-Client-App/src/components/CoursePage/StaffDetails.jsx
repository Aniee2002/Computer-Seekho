import React, { useEffect, useState } from "react";

const StaffDetails = () => {
  const [staffList, setStaffList] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        console.log("Fetching staff data...");
        const response = await fetch("http://localhost:8080/staff/getAll");
  
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }
  
        const data = await response.json();
        console.log("Fetched staff data:", data); // ✅ Log response to debug
  
        setStaffList(data);
      } catch (error) {
        console.error("Error fetching staff data:", error);
      } finally {
        setLoading(false); // ✅ Ensure loading stops even if there's an error
      }
    };
  
    fetchData();
  }, []);
  

  return (
    <div>
      <h1 className="title">Our Instructors</h1>
      {loading ? (
        <p>Loading staff data...</p>
      ) : staffList.length > 0 ? (
        <div className="staff-container">
          {staffList.map((staff, index) => (
            // Create a new row after every two staff members
            index % 2 === 0 ? (
              <div className="staff-row" key={staff.staffId}>
                <div className="staff-card">
                  <div className="staff-header">
                    <h2 className="staff-name">{staff.staffName}</h2>
                    <p className="staff-title">{staff.staffRole.replace("ROLE_", "")}</p>
                    <img src={staff.photoUrl} alt={staff.staffName} className="staff-image" />
                  </div>
                  <div className="staff-info">
                    <p>📧 {staff.staffEmail}</p>
                    <p>📞 {staff.staffMobile}</p>
                    <p>⚥ {staff.staffGender}</p>
                  </div>
                </div>

                {/* Render the next staff member in the same row if available */}
                {staffList[index + 1] && (
                  <div className="staff-card" key={staffList[index + 1].staffId}>
                    <div className="staff-header">
                      <h2 className="staff-name">{staffList[index + 1].staffName}</h2>
                      <p className="staff-title">{staffList[index + 1].staffRole.replace("ROLE_", "")}</p>
                      <img src={staffList[index + 1].photoUrl} alt={staffList[index + 1].staffName} className="staff-image" />
                    </div>
                    <div className="staff-info">
                      <p>📧 {staffList[index + 1].staffEmail}</p>
                      <p>📞 {staffList[index + 1].staffMobile}</p>
                      <p>⚥ {staffList[index + 1].staffGender}</p>
                    </div>
                  </div>
                )}
              </div>
            ) : null
          ))}
        </div>
      ) : (
        <p>No faculty data found.</p>
      )}
    </div>
  );
};

export default StaffDetails;