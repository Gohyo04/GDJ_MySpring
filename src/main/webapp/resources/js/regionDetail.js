/**
 * 
 */
 const del = document.getElementById('del');
 const frm = document.getElementById('frm');
 const up = document.getElementById('up');

 
 del.addEventListener("click", function(){
    let result = confirm("정말지우시겠습니까?");

    if(result){
        frm.submit();
    }
 });


 up.addEventListener('click', function(){
    frm.setAttribute("action","update");
    frm.setAttribute("method","get");
    frm.submit();
    
    // let id = up.getAttribute('data-region-id');
    // location.href="./update?region_id="+id;
 });

