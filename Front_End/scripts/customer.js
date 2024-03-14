getAllCustomer();
function getAllCustomer() {
    $("#tblCustomer").empty();

    $.ajax({
        url: 'http://localhost:8080/app/customer',
        method: 'GET',
        success:function (customer) {
            for (let i in customer) {
                let cus = customer[i];
                let id = cus.id;
                let name = cus.name;
                let address = cus.address;
                let salary=cus.salary;
                let row=`<tr><td>${id}</td><td>${name}</td><td>${address}</td><td>${salary}</td></tr>`;
                $("#tblCustomer").append(row);
            }
        },
        error:function (err) {
            alert("ERROR LOAD DATA")
        }
    });
}
$("#btnGetAll").click(function () {
    alert("bdwjfkw");
    getAllCustomer();
});
$("#btnSaveCustomer").click(function () {
    let formData=$("#customerForm").serialize();
    $.ajax({
        url:'http://localhost:8080/javaEE_Pos/cus',
        method:'post',
        data:formData,
        success:function (res) {
            getAllCustomer();
            alert(res.massage);
        },
        error:function (err) {
            alert(e.responseJSON.massage);
        }
    });
});

$("#btnUpdate").click(function () {

    let cusId = $("#txtCustomerID").val();
    let cusName = $("#txtCustomerName").val();
    let cusAddress = $("#txtCustomerAddress").val();
    let cusSalary=$("#txtCustomerSalary").val();

    let customerObj={
        id:cusId,
        name:cusName,
        address:cusAddress,
        salary:cusSalary
    }

    $.ajax({
        url:'http://localhost:8080/javaEE_Pos/cus',
        method:'PUT',
        data: JSON.stringify(customerObj), // Convert the object to JSON string
        contentType: 'application/json',
        success:function (res) {
            alert("Customer Updated Succus");
            getAllCustomer();
        },
        error:function (err) {
            alert(e.responseJSON.massage);
        }
    });
});

$("#btnCusDelete").click(function () {
    let cusId = $("#txtCustomerID").val();
    $.ajax({
        url:'http://localhost:8080/javaEE_Pos/cus?id='+cusId,
        method:'DELETE',
        success:function () {
            getAllCustomer();
            alert("Customer Deleted Succuss");
        },error:function () {
            alert(e.responseJSON.massage);
        }
    });
});
