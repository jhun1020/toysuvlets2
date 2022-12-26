const questions_list = [
  {
    question: "해당 매장을 방문시 매장은 청결 하였습니까?",
    questions_uid: "Q1",
    order: 1,
  },
  {
    question: "주문시 직원은 고객님께 친절 하였습니까?",
    questions_uid: "Q2",
    order: 2,
  },
  {
    question: "주문하신 음료가 나오기까지 시간이 적당하였습니까?",
    questions_uid: "Q3",
    order: 3,
  },
  {
    question: "해당 매장을 다음에도 재방문 하실 의향이 있으십니까?",
    questions_uid: "Q5",
    order: 4,
  },
  {
    question: "직원이 제조한 음료에 대해 맛은 좋았습니까?",
    questions_uid: "Q4",
    order: 5,
  },
];

const answer_list = [
  { answer: "전혀 아니다", answer_uid: "E1", order: 1 },
  { answer: "아니다", answer_uid: "E2", order: 2 },
  { answer: "보통이다", answer_uid: "E3", order: 3 },
  { answer: "그렇다", answer_uid: "E4", order: 4 },
  { answer: "매우 그렇다", answer_uid: "E5", order: 5 },
];

const questions_answers = [
  { questions_uid: "Q1", answer_uid: "E1" },
  { questions_uid: "Q1", answer_uid: "E2" },
  { questions_uid: "Q1", answer_uid: "E3" },
  { questions_uid: "Q2", answer_uid: "E1" },
  { questions_uid: "Q2", answer_uid: "E2" },
  { questions_uid: "Q2", answer_uid: "E3" },
  { questions_uid: "Q2", answer_uid: "E4" },
  { questions_uid: "Q3", answer_uid: "E1" },
  { questions_uid: "Q3", answer_uid: "E2" },
  { questions_uid: "Q4", answer_uid: "E1" },
  { questions_uid: "Q4", answer_uid: "E2" },
  { questions_uid: "Q4", answer_uid: "E3" },
  { questions_uid: "Q4", answer_uid: "E4" },
  { questions_uid: "Q4", answer_uid: "E5" },
  { questions_uid: "Q5", answer_uid: "E1" },
  { questions_uid: "Q5", answer_uid: "E2" },
  { questions_uid: "Q5", answer_uid: "E3" },
];

// // 디스플레이 되어야할 내용
// [
//   [Q1, E1, E2][(Q2, E1, E2, E3)][(Q3, E1, E2)][(Q4, E1, E2, E3, E4, E5)][
//     (Q5, E1, E2, E3)
//   ],
// ];
let question_compare;
let polls = []; // 외부 묶음
let questions = {}; // 내부 묶음
let answer_uids = []; // 내부 설문 답변 묶음
for (let idx = 0; idx < questions_answers.length; idx++) {
  if (question_compare != questions_answers[idx]["questions_uid"]) {
    if (Object.keys(questions).length > 0) {
      questions["answer_uids"] = answer_uids;
      polls.push(questions);
      questions = {};
      answer_uids = [];
    }

    // console.log(`!= : ${questions_answers[idx]["questions_uid"]}`);
    // console.log(`!= : ${questions_answers[idx]["answer_uid"]}`);
    questions["questions_uid"] = questions_answers[idx]["questions_uid"];
    answer_uids.push(questions_answers[idx]["answer_uid"]);
  } else {
    // console.log(`== : ${questions_answers[idx]["answer_uid"]}`);
    answer_uids.push(questions_answers[idx]["answer_uid"]);
    if (idx + 1 >= questions_answers.length) {
      questions["answer_uids"] = answer_uids;
      polls.push(questions);
    }
  }
  question_compare = questions_answers[idx]["questions_uid"]; // 이전 uid 입력
}

// 설문 문항을 가져오는 function
// Q1 해당 매장을 방문시 매장은 청결 하였습니가?
// 1. e1
// 2. e2
// Q2. 주문시 직원은 고객님께 친절 하였습닉?ㅏ?
// ...

// // 내가 해 본 func      ----------
// function getQuestionByUid(question_uid) {
//   let question_desc;
//   for (list of questions_list) {
//     if (list["question_uid"] == questions_uid) {
//       question_desc = list["question"];
//     }
//   }
//   return question_desc;
// }
// // ------------------------

// 강사님이 하신 func
function getQuestionByUid(question_uid) {
  let question_desc = "";
  // question_uid = 'Q1'
  for (question of questions_list) {
    if (question["questions_uid"] === question_uid) {
      question_desc = question["question"];
      break;
    }
  }
  return question_desc;
}

function getAnswerByUid(answer_uid) {
  let answer_desc = "";
  for (answer of answer_list) {
    if (answer["answer_uid"] === answer_uid) {
      answer_desc = answer["answer"];
      break;
    }
  }
  return answer_desc;
}

for (poll of polls) {
  let question_desc = getQuestionByUid(poll["questions_uid"]);
  // console.log(`${poll["questions_uid"]}. ${question_desc}`); // == polls[idx]
  let answer_uids = poll["answer_uids"];
  answer_uids.forEach((answer_uid, index) => {
    // answers
    // console.log(`${index + 1}. ${getAnswerByUid(answer_uid)}`);
  });
}

// Event handlers
// Next 클릭 시 순서 있게 설문 표시
// 대상 변수는 polls
let queryNext = document.querySelector("#next");
queryNext.addEventListener("click", setPollContent);

let index = 0;
function setPollContent() {
  let queryContent = document.querySelector("#poll-contents");
  // polls[0]["questions_uid"]; // 설문 문항
  // polls[0]["answer_uids"]; // 설문 답항 묶음
  // getQuestionByUid(polls[index]["questions_uid"]);
  //        1.        매장 상태가 좋은가요?

  if (index < questions_list.length) {
    let desc = `<div>${index + 1}. ${getQuestionByUid(
      polls[index]["questions_uid"]
    )}</div><br>`;
    polls[index]["answer_uids"].forEach((answer_uid, index) => {
      // console.log(`${index + 1}. ${getAnswerByUid(answer_uid)}`);
      desc += `<div><input type="radio" name="choice" id="radio${index}"><label for="radio${index}">${
        index + 1
      }. ${getAnswerByUid(answer_uid)}</label></div>`;
    });
    queryContent.innerHTML = desc;
    index++;
  } else {
    clickAlert();
  }
}
// next, prev 둘 다 사용 하기 위해 func로 만들었음.
function clickAlert() {
  alert("경고");
}

let queryPrev = document.querySelector("#prev");
queryPrev.addEventListener("click", setPollContent_prev);
let index_prev = questions_list.length - 1; // 5 -1

function setPollContent_prev() {
  if (index == 1) {
    clickAlert();
  } else {
    let queryContent_prev = document.querySelector("#poll-contents");
    // 질문부분
    let desc_prev = `<div>${index - 1}. ${getQuestionByUid(
      polls[index - 2]["questions_uid"]
    )}</div><br>`;
    // 답변부분
    polls[index - 2]["answer_uids"].forEach((answer_uid, index) => {
      // console.log(`${index + 1}. ${getAnswerByUid(answer_uid)}`);
      desc_prev += `<div><input type="radio" name="choice" id="radio${index}"><label for="radio${index}"> ${
        index + 1
      }. ${getAnswerByUid(answer_uid)}</label></div>`;
    });

    queryContent_prev.innerHTML = desc_prev;
    index--;
  }
}
