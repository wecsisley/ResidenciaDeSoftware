const array = [1, 2, 3, 4, 5, 6, 7, 8];

const teste1 = [a, b, c, d, ...e] = array
const teste2 = [j, j, j, ...h] = array


function soma(...params) {
    let accumulator = 0;
    params.map(value => {
        accumulator = accumulator + value;
    })
    console.log(accumulator)
}

console.log(j, h)
console.log(a, b, c, d, e)
soma(a, j, d)