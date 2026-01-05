import React from 'react';

function Navbar() {
  return (
    <nav className="bg-white shadow-md mb-8">
      <div className="max-w-6xl mx-auto px-4">
        <div className="flex justify-between items-center py-4">
          
          {/* Logo Section */}
          <div className="flex items-center space-x-2">
            <div className="w-8 h-8 bg-blue-600 rounded-lg flex items-center justify-center">
              <span className="text-white font-bold text-lg">S</span>
            </div>
            <span className="text-xl font-bold text-gray-800">StudentSys</span>
          </div>

          {/* Menu Items (Visual only for now) */}
          <div className="hidden md:flex space-x-6 text-gray-600 font-medium">
            <a href="#" className="hover:text-blue-600 transition-colors">Dashboard</a>
            <a href="#" className="hover:text-blue-600 transition-colors">Students</a>
            <a href="#" className="hover:text-blue-600 transition-colors">Settings</a>
          </div>

          {/* User Profile */}
          <div className="flex items-center space-x-2">
            <div className="w-8 h-8 rounded-full bg-gray-200 border border-gray-300"></div>
            <span className="text-sm font-medium text-gray-700">Admin</span>
          </div>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;