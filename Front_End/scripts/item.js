getAllItem();
function getAllItem() {
    $("#tblItem").empty();

    $.ajax({
        url: 'http://localhost:8080/javaEE_Pos/item',
        method: 'get',
        success:function (item) {
            for (let i in item) {
                let It = item[i];
                let id = It.itemId;
                let des = It.itemDes;
                let up = It.itemUp;
                let qty=It.itemQty;
                let row=`<tr><td>${id}</td><td>${des}</td><td>${up}</td><td>${qty}</td></tr>`;
                $("#tblItem").append(row);
            }
        },
        error:function (err) {
            alert("ERROR LOAD DATA")
        }
    });
}

$("#btnItemGetAll").click(function () {
    getAllItem();
});

$("#btnSaveItem").click(function () {
    let formData=$("#ItemForm").serialize();
    $.ajax({
        url:'http://localhost:8080/javaEE_Pos/item',
        method:'post',
        data:formData,
        success:function (res) {
            getAllItem();
            alert(res.massage);
        },
        error:function (err) {
            alert(e.responseJSON.massage);
        }
    });
});

$("#btnItemUpdate").click(function () {
    let itemId = $("#txtItemID").val();
    let itemDes = $("#txtItemDes").val();
    let itemUp = $("#txtItemUnitPrice").val();
    let itemQty=$("#txtItemQty").val();

    let itemObj={
        id:itemId,
        des:itemDes,
        up:itemUp,
        qty:itemQty
    }
    $.ajax({
        url:'http://localhost:8080/javaEE_Pos/item',
        method:'PUT',
        data: JSON.stringify(itemObj), // Convert the object to JSON string
        contentType: 'application/json',
        success:function (res) {
            alert(res.massage);
            getAllItem()
        },
        error:function (err) {
            alert(e.responseJSON.massage);
        }
    });
});

$("#btnItemDelete").click(function () {
    let itemID = $("#txtItemID").val();
    $.ajax({
        url:'http://localhost:8080/javaEE_Pos/item?id='+itemID,
        method:'DELETE',
        success:function (res) {
            getAllItem()
            alert(res.massage);
        },error:function () {
            alert(e.responseJSON.massage);
        }
    });
});