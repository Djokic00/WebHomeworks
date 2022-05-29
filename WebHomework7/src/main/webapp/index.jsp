<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Blogs</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<div class="container">
    <div id="main">

    </div>

</div>

<script>
    fetch('/index/posts', {
        method: 'GET'
    }).then(response => {
        return response.json();
    }).then(posts => {
        const mainDiv = document.getElementById('main')
        const blogs = document.createElement('h1');
        blogs.innerText = 'Blogs'
        mainDiv.appendChild(document.createElement('br'))
        mainDiv.appendChild(document.createElement('br'))
        mainDiv.appendChild(blogs)
        mainDiv.appendChild(document.createElement('br'))
        for (const post of posts) {
            addPostElements(post)
        }
        const newPostButton = document.createElement('button');
        newPostButton.innerText = 'New post'
        newPostButton.classList.add('btn', 'btn-primary')
        newPostButton.style.marginLeft = '10px'
        newPostButton.onclick = ()=> newPostForm()
        mainDiv.appendChild(newPostButton);
        mainDiv.appendChild(document.createElement('br'))

    })

    function saveComment(postId) {
        const mainDiv = document.getElementById('main');
        const name = document.getElementById('name').value
        const comment = document.getElementById('comment').value
        fetch('index/posts/' + postId + '/comments', {
            method: 'POST',
            headers:{
                'Content-Type':'application/json'
            },
            body: JSON.stringify({
                author: name,
                content: comment
            })
        }).then(response => response.json()
        ).then(comment => {
            const commentName = document.createElement('h5')
            commentName.innerText = comment.author
            mainDiv.appendChild(commentName)
            const commentComment = document.createElement('h6')
            commentComment.innerText = comment.content
            mainDiv.appendChild(commentComment)
        })


    }

    function postDetails(post) {
        const mainDiv = document.getElementById('main');
        mainDiv.innerHTML = '';
        const title = document.createElement('h1')
        title.innerText = post.title
        const createdAt = document.createElement('h5')
        createdAt.innerText = new Date(post.createdAt)
        const author = document.createElement('h6')
        author.innerText = post.author
        const content = document.createElement('p')
        content.innerText = post.content
        mainDiv.appendChild(title)
        mainDiv.appendChild(createdAt)
        mainDiv.appendChild(author)
        mainDiv.appendChild(content)
        mainDiv.appendChild(document.createElement('br'))
        const newComment = document.createElement('h3')
        newComment.innerText = 'New comment'
        mainDiv.appendChild(newComment)
        const formForNewComment = document.createElement('form')
        formForNewComment.method = 'POST'

        const divName = document.createElement('div');
        divName.className = 'form-group'
        const labelForName = document.createElement('label');
        labelForName.innerText = 'Name'
        const inputName = document.createElement('input')
        inputName.type = 'text'
        inputName.className = 'form-control'
        inputName.id = 'name'
        inputName.name = 'name'
        inputName.placeholder = 'Enter your name'
        inputName.required = true
        divName.appendChild(labelForName);
        divName.appendChild(inputName);
        formForNewComment.appendChild(divName)

        const divComment = document.createElement('div');
        divComment.className = 'form-group'
        const labelForComment = document.createElement('label');
        labelForComment.innerText = 'Comment'
        const inputCommment = document.createElement('input')
        inputCommment.type = 'text'
        inputCommment.className = 'form-control'
        inputCommment.id = 'comment'
        inputCommment.name = 'comment'
        inputCommment.placeholder = 'Enter a comment'
        inputCommment.required = true
        divComment.appendChild(labelForComment);
        divComment.appendChild(inputCommment);
        formForNewComment.appendChild(divComment)

        const newCommentButton = document.createElement('button');
        newCommentButton.innerText = 'Comment'
        newCommentButton.classList.add('btn', 'btn-primary')
        newCommentButton.type = 'button'
        newCommentButton.style.marginLeft = '10px'
        newCommentButton.onclick = () => saveComment(post.postId)
        formForNewComment.appendChild(newCommentButton)

        mainDiv.appendChild(formForNewComment)

        mainDiv.appendChild(document.createElement('br'))
        mainDiv.appendChild(document.createElement('br'))

        const allComments = document.createElement('h3')
        allComments.innerText = 'Comments'
        const div = document.createElement('div')
        mainDiv.appendChild(allComments)
        for (const comment of post.comments) {

            const commentName = document.createElement('h5')
            commentName.innerText = comment.author
            mainDiv.appendChild(commentName)
            const commentNew = document.createElement('h6')
            commentNew.innerText = comment.content
            mainDiv.appendChild(commentNew)
            mainDiv.appendChild(document.createElement('br'))
        }
        mainDiv.appendChild(document.createElement('hr'))

    }

    function addPostElements(post) {
        const mainDiv = document.getElementById('main');
        const wrap = document.createElement('div');
        wrap.className = 'card';
        const cardBody = document.createElement('div');
        cardBody.className = 'card-body';
        const postTitle = document.createElement('h3');
        postTitle.className = 'card-title';
        postTitle.innerText = post.title;
        const postContent = document.createElement('p');
        postContent.className = 'card-cont';
        postContent.innerText = post.content;
        const postOpsirnije = document.createElement('a');
        postOpsirnije.className = 'ops';
        postOpsirnije.innerText = 'Opsirnije...';

        postOpsirnije.onclick = ()=>postDetails(post);
        mainDiv.appendChild(document.createElement('br'))

        cardBody.appendChild(postTitle);
        cardBody.appendChild(postContent);
        cardBody.appendChild(postOpsirnije);
        cardBody.appendChild(document.createElement('br'));
        wrap.appendChild(cardBody);
        mainDiv.appendChild(wrap);
        mainDiv.appendChild(document.createElement('br'))

    }

    function savePost() {

        const author = document.getElementById('author').value
        const title = document.getElementById('title').value
        const content = document.getElementById('content').value
        fetch('index/posts', {
            method: 'POST',
            headers:{
                'Content-Type':'application/json'
            },
            body: JSON.stringify({
                author: author,
                title: title,
                content: content
            })
            }).then(post=> {
                addPostElements(post)
                console.log(post)
                window.location.reload()
            }
        )
    }

    function newPostForm() {
        const mainDiv = document.getElementById('main');
        mainDiv.innerHTML = '';
        const newForm = document.createElement('form');
        newForm.method = 'POST'

        const divGroupAuthor = document.createElement('div');
        divGroupAuthor.className = 'form-group'
        const labelForAuthor = document.createElement('label');
        labelForAuthor.innerText = 'Author'
        const inputAuthor = document.createElement('input')
        inputAuthor.type = 'text'
        inputAuthor.className='form-control'
        inputAuthor.id = 'author'
        inputAuthor.name = 'author'
        inputAuthor.placeholder = 'Enter a author\'s name'
        inputAuthor.required = true
        divGroupAuthor.appendChild(labelForAuthor);
        divGroupAuthor.appendChild(inputAuthor);
        newForm.appendChild(divGroupAuthor)

        const divGroupTitle = document.createElement('div');
        divGroupTitle.className = 'form-group'
        const labelForTitle = document.createElement('label');
        labelForTitle.innerText = 'Title'
        const inputTitle = document.createElement('input')
        inputTitle.type = 'text'
        inputTitle.className='form-control'
        inputTitle.id = 'title'
        inputTitle.name = 'title'
        inputTitle.placeholder = 'Enter a title'
        inputTitle.required = true
        divGroupTitle.appendChild(labelForTitle);
        divGroupTitle.appendChild(inputTitle);
        newForm.appendChild(divGroupTitle)

        const divGroupContent = document.createElement('div');
        divGroupContent.className = 'form-group'
        const labelForContent = document.createElement('label');
        labelForContent.innerText = 'Content'
        const textareaContent = document.createElement('textarea')
        textareaContent.type = 'text'
        textareaContent.className='form-control'
        textareaContent.rows = 8
        textareaContent.cols = 40
        textareaContent.id = 'content'
        textareaContent.name = 'content'
        textareaContent.placeholder = 'Enter a content'
        textareaContent.required = true
        divGroupContent.appendChild(labelForContent);
        divGroupContent.appendChild(textareaContent);
        newForm.appendChild(divGroupContent)

        const newPostButton = document.createElement('button');
        newPostButton.innerText = 'Save post'
        newPostButton.classList.add('btn', 'btn-primary')
        newPostButton.type = 'button'
        newPostButton.style.marginLeft = '10px'
        newPostButton.onclick = ()=>savePost()
        newForm.appendChild(newPostButton)

        mainDiv.appendChild(newForm)
    }

</script>
</body>
</html>

