import styled from 'styled-components'

export const Nav = styled.div`
    background-color:  blueviolet;
    border-radius: 10px;
    padding-top: 1px;
    padding-bottom: 1px;

    .menuLink{
        text-decoration: none;
        color:black;
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
export const All = styled.div`
    background-color: grey;
    width: 300px;
    height: 300px;
    padding: 10px;
    margin: 50px;
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

`;

export const CardAll = styled.div`

`;

export const TituloCategoria = styled.div`

`;

export const ImagemCategoria = styled.div`

`;

export const DescricaoCategoria = styled.div`

`;