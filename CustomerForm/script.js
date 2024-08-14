$('#submit').on('click', function(event) {
    event.preventDefault();  // Prevent form submission for testing purposes
    
    var Cid = $('#cusId').val();
    var Cname = $('#cusName').val();
    var Caddress = $('#cusAddress').val();
    var Ctel = $('#cusTel').val();


    $.ajax({
        url:"http://localhost:8080/customer",
        method:"POST",
        contentType:"application/json",
        "data":JSON.stringify({
            id:Cid,
            name:Cname,
            address:Caddress,
            tel:Ctel
        }),

        success:function(results){
            console.log(results);
            Swal.fire({
                title: "Saved Successfully",
                text: "You clicked the button!",
                icon: "success"
              });
        },

        error:function(error){
            console.log(error);
            Swal.fire({
                icon: "error",
                title: "Saved Failed",
                text: "Something went wrong!",
              });
        }

    });
});
