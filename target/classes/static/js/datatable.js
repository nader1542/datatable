$(document).ready( function () {
	 var table = $('#employeesTable').DataTable({
		 "processing": true,
	        "serverSide": true,
	        "ajax": {
	        "url": "employees",
	        "type": "POST",
	        "data": {
	            "user_id": 451
	        }},
	        "aoColumns": [
			      { "mData": "id"},
		          { "mData": "name" },
				  { "mData": "lastName" },
				  { "mData": "email" },
				  { "mData": "phone" },
				  { "mData": "active" }
			]
	 })
});