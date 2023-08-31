document.querySelector('#push').onclick = function(){
    if(document.querySelector('#newtask input').value.length == 0){
        alert("Please Enter a Task")
    }

    else{
        document.querySelector('#tasks').innerHTML += `
            <div class="task">
                <span id="taskname">
                    ${document.querySelector('#newtask input').value}
                </span>
                <button class="delete">
                    <i class="far fa-trash-alt"></i>
                </button>
            </div>
        `;

        var current_tasks = document.querySelectorAll(".delete");
        for(var i=0; i<current_tasks.length; i++){
            current_tasks[i].onclick = function(){
                this.parentNode.remove();
            }
        }
    }
}












































// // Jquery

// $(document).ready(function(){
//     $('#input').change(function(){
//     var input=$(this).val();
//     $('ul').append('<li>'+input+'  <i class="fas fa-check"></i> <i class="fas fa-trash"></i> </li>');
//     $(this).val();
//     })


// })