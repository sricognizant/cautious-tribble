// const questions = [
//   {
//     question: 'Who is the CEO of Cognizant ?',
//     choices: [
//       'A] Linus Torvalds',
//       'B] James Gosling',
//       'C] Steve Jobs',
//       'D] Brian Humphries'
//     ],
//     answer: 3
//   },
//   {
//     question: 'What do you mean by CDE?',
//     choices: [
//       'A] Cognizant Digital Education',
//       'B] Cognizant Digital Engineers',
//       'C] Cognizant Digital Engineering',
//       'D] Cognizant Digital Enterprise'
//     ],
//     answer: 2
//   },
//   {
//     question: 'First principal technical architect in CDE?',
//     choices: [
//       'A] Linus Torvalds',
//       'B] Rizal Jose',
//       'C] RizaLino Yabut',
//       'D] Robiol Bahoo'
//     ],
//     answer: 2
//   }
// ];

const randomQuestions = async () => {
  let response = await fetch('http://localhost:53375/questions');
  let data = await response.json();

  console.log(data);

  const newData = {
    ...data,
    choices: data.choices.split('|')
  };

  console.log(newData);
  return newData;
};

// function shuffle(o) {
//   for (
//     var j, x, i = o.length;
//     i;
//     j = parseInt(Math.random() * i), x = o[--i], o[i] = o[j], o[j] = x
//   );
//   return o;
// }
export default randomQuestions;
