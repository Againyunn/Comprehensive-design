//앱 전체의 Header
import React from 'react'
import styled from 'styled-components'

export default function Header() {

  const BackgroundBlock = styled.div`
    div.containerHeader{
      min-height: 5vh;
      display: flex;
      flex-direction: row;
      flex-wrap: nowrap;
      background-color: white;

      
      padding-bottom: 15px;
      border-bottom: solid 2px #002F5A;
    }

    div.menu{
      padding-top: 10px;
      flex-basis: 10%;
      flex-grow: 1;
      background-color: white;
    }

    div.blank{
      flex-grow: 5;

      /*글씨*/
      padding-top: 5%;
      font-size: 18px;
      color: #002F5A;
      font-weight: bold;
    }

    div.logo{
      padding-top: 10px;
      flex-grow: 1;
      flex-basis: 7%;
      background-color: white;
    }
  `


  return (
    <BackgroundBlock>
      <div className='containerHeader'>
        <div className='logo'><img src={require('../../media/structure/로고.png')} alt='로고' style={{width:'40px', height:'40px'}}/></div>
        <div className='blank'>너의 이중전공은?</div>
        <div className='menu'></div>
      </div>
    </BackgroundBlock>
  )
}



// ={process.env.PUBLIC_URL +`${'/media/structure/메뉴2.jpg'}`