// const css = {fontSize: 12, color: '#FFF'};

// const tituloCss = {
//     fontWeight: 'bold',
//     ...css,
//     fontSize: 20,
// }

// console.log(tituloCss)

function soma(...params) {
    let accumulator = 0;
    params.map(value => {
        accumulator = accumulator + value
    })

    console.log(accumulator)
}

soma(1,2,4)