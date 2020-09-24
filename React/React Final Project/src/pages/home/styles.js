import styled from 'styled-components';



export const Menu = styled.div`

        .link-button {
            margin-left: auto;
        }

        .link-button ul li {
            display: inline;
            list-style: none;
            padding-left: 25px; 
                   
        }

        .link {
            text-decoration: none;
        }

        .link:hover {
            color: white;
        }

`;
export const MainContainer = styled.div`
`;

export const Header = styled.div`

        margin-bottom: 30px;

`;

export const Form = styled.div`
        
        .searchBar {
            width: 80%;
            margin-bottom: 20px;
            margin-left: 15px;    
                                    
        }

        .button {
            margin-left: 10px;
            border-radius: 5px;
            width: 60px;
            
        }


`;

export const Footer = styled.div`

        width: 100%;
        heigth: 100px;
        background-color:#3f51b5;
        margin-top:50px;
        
`;

export const CardStyle = styled.div`

        width:auto;
        height:100%;
                 
   
 `;

 export const Card = styled.div`
         
         border: inset;
         border-radius:5px;
    
 `;
export const CardMedia = styled.div`

    overflow: hidden; 

    img {
        width:100%;
        height: auto;
       
}
`;

export const CardDescription = styled.div`

    p{
        text-align: center;
        font-size:15px;

    }

    strong {
        font-size: 20px;
    }

`;

export const CardButton = styled.div`

    .button-menu {
               
    }

    .button-menu  li {
        list-style: none;
        float: left; 
        padding-left: 30px;
           
                                  

    }
    
    .link {
        text-decoration: none;
        padding-left: 10px;
        margin-left: auto;
        

    }

    .link:hover {
        color: green;
    }

`;