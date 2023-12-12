$(function(){


//     $("#more").click(function(){
//         var next_page = parseInt($(this).attr("current-page")) + 1;
//         $.ajax({
//             method:"GET",
//             url:"/post",
//             data:{"page": next_page}
//         })
//         .done(function(response) { // hàm call back dữ liệu trả về sau khi rest API Get dc gọi và lưu vào response
//              for(var post of response) {   //Dữ liệu trả về dưới dạng mảng json, dùng vòng lặp để chuyển đổi
//              // các đối tượng json trong mảng thành tài liệu html hiển thị
//
//              //more-posts là khu vực đã tạo trc để thêm các bài post mới
//                  $("#more-posts").append("<div class=\"post-preview\">" +
//                  "<a href=\"#\">" +
//                  "<h2 class=\"post-title\">" + // nối các thẻ html lại với nhau
//                  post.title +
//                  "</h2>\n" +
//                  "<h3 class=\"post-subtitle\">" +
//                  post.content +
//                  "</h3></a><p class=\"post-meta\">Posted by" +
//                  post.username +
//                  "</p></div><hr class=\"my-4\" />");
//                  }
//         });
//         //current-page hiện tại có giá trị bằng 1 đã thiết lặp bên file index.mustache
//         $(this).attr("current-page", next_page);// tham số next_page sẽ chuyền dữ liệu vào "current-page
//                                                 // mỗi khi nhấp nút more là tăng thêm 1
//     });


     $("#create_button").click(function(){
         var title = $("#post-title").val();
         var username = $("#post-username").val();
         var content = $("#post-content").val();

         $.ajax({
             method:"POST",
             url:"/post",
             data: JSON.stringify({
                 "title":title,
                 "username":username,
                 "content":content
             }),
             contentType: "application/json"
         })

         //Code dưới đây đc gọi khi ajax thực hiện thành công

         .done(function(response){
             console.log("Post creation success!");
             window.location.href = "/";  // màn hình sẽ tự chuyển đến trang index khi post đc lưu thành công
         });
     });



     $("#edit_button").click(function(){
              var id = $("#edit-post-id").val();   //id
              var title = $("#edit-post-title").val();  //title
              var content = $("#edit-post-content").val();   //content

              $.ajax({
                  method:"PUT",
                  url:"/post",
                  data: JSON.stringify({
                      "id":id,
                      "title":title,
                      "content":content
                  }),
                  contentType: "application/json"
              })

              //Code dưới đây đc gọi khi ajax thực hiện thành công

              .done(function(response){
                  console.log("Post update success!");
                  window.location.href = "/post/" + id;  // màn hình sẽ tự chuyển đến trang chi tiết bài đăng đã chỉnh sửa
                                                         // bằng thông tin id
              });
          });





     $(".comment-edit").hide();

     $(".comment-edit-form-button").click(function(){
         $(this).closest(".comment_text").find(".comment-edit").show();
     });

     $(".comment-edit-cancel-button").click(function(){
         $(this).closest(".comment_text").find(".comment-edit").hide();
     });
});