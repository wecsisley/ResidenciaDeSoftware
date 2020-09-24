import styled from 'styled-components';


export const Form = styled.div`
    margin-top:10px;

    .header {
        margin-top:10px;
        
       
    }
      
    .header span {
        border: solid 1px; 
        display:flex;          
        margin-top:5%;
        margin-left:30%;
        margin-right:30%;      
        padding:30px;
        justify-content: center;
        font-weight:bold;
        color:white;
        background-color:#3d6566;
        border-radius:10px;
          

    }

    .input {
        height:20px;
        margin-top:30px;
    }

    .content {
        display: flex;
        flex-direction: column;
        width:80%;
        height:1000px;        
        margin-left:10%;
        margin-right:10%;
        margin-top:20px;

    }

    .button-style {
        width:30%;
        margin-left:35%;
        padding: 10px;
        background-color:#3d6566;
        border:solid 1px;
        border-radius: 5px;
        background-color:white;
        color: #57a6a8;
        font-weight: bold;
        cursor:pointer;
    }

    .button-style:hover{
        background-color:#87b6b8;
        color: white;
    }
   
`;
