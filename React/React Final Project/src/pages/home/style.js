import styled from 'styled-components'

export const Container = styled.div`
    font-family: 'Roboto',sans-serif;

    
`;

export const Nav = styled.div`
    background-color: #5f9ea0;
    border-radius: 10px;
    width: 100%;


    .titulo{       
        font-size:20px;
        padding-left:20px;
        padding-top:30px;
        padding-bottom:2px;
        color:white;
        

    }

    .menuLink{
        text-decoration: none;
        color:white;
        font-size: 18px;
    }

    .menuLink: hover{
        color: #008080;
    }

    .menuNav {
        display: flex;
        justify-content: flex-end;
    }
`;


export const List = styled.li`
    list-style:none;
    display: inline;
    padding: 10px;
`;

export const Content = styled.div`
`;

export const Card = styled.div`
    background-color: #cadede;
    border-radius: 7px;
    width: 300px;
    height: 200px;        
    margin: 50px;
    float:right;
    float:left;  
    margin-bottom:10%;
    
    
    .button-card {       
        padding-left:210px;
        margin-left: 10%;
        margin-bottom:5%;
        margin-top:15%;
        color:#103E61;

           .refresh {
               margin-right:20%;
           }
           .refresh:visited {
               color:#2612A6;
           }
           
           .delete {
               margin-right:6%;
           }

           .delete:visited {
               color:#2612A6;
           }
    }
 
`;

export const Main = styled.div`
    .menuNavegacao {
        margin-left: 10%;
        padding-top: 1%;
   }
    .inputType {
        width: 80%;
        padding: 5px;
        border-radius: 5px;
        border: solid 0.5px;
    }
    .botaoPesquisa {
        margin-left: 10px;
        padding: 5px;
        border-radius: 5px;
    }
    .botaoPesquisa: hover{
        background-color: red;
    }
`;

export const SearchBar = styled.div`
    .menuNavegacao {
        margin-left: 10%;
        padding-top: 1%;
   }
    .inputType {
        width: 80%;
        padding: 5px;
        border-radius: 5px;
        border: solid 0.5px #406768;
        background-color: #e4eeef;
    }
    .botaoPesquisa {
        margin-left: 10px;
        padding: 5px;
        border-radius: 5px;
        border: solid 1px;
        background-color:white;
        color: #57a6a8;
        font-weight: bold;
        cursor:pointer;
    }
    .botaoPesquisa:hover {
        background-color:#87b6b8;
        color: white;
    }
`;

export const CardAll = styled.div`
`;


export const TituloCategoria = styled.div`
    border: 60px;
    border-radius:7px;
    background-color:#3d6566;
    color: white;    
    padding:5%;
    text-align: center;
    font-weight: bold;
`;

export const ImagemCategoria = styled.div`
`;

export const DescricaoCategoria = styled.div`
        padding-left:40px;
        padding-top:10px;
        color: #3d6566;
        font-weight: bold;


`;

export const All = styled.div`

`;


export const Footer = styled.div`
    background-color: #5f9ea0;
    border-radius: 10px;
    padding-top: 15px;
    padding-bottom: 20px;
    bottom:0;
    position: fixed;
    width: 100%;
    
    
    
`;



