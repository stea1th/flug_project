$(document).ready(function(){
    $("#customerForm").submit(function (event) {
        event.preventDefault();
        ajaxPost();
    });

    function ajaxPost(){
        var formData = $("#filename").val();
        //     filename : $("#filename").val()
        // }

        $.ajax({
            type : "POST",
            contentType : "text/plain",
            url : window.location + "/upload",
            data : formData,
            dataType : 'text',
            success : function (result) {
                if(result === "Done"){
                    $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                        "Post Successfully! <br>" +
                        "---> FileName's Info: Filename = " +
                        result  + "</p>");
                }else{
                    $("#postResultDiv").html("<p style='background-color:#b05f53; color:white; padding:20px 20px 20px 20px'>" +
                        "Data Type Error <br>" +
                        "---> This File is corrupt!</p>");
                }
                console.log(result)
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }

        });
        resetData();
    }

    function resetData() {
        $("#filename").val("");
    }
})