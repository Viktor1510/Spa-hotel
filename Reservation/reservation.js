const daysTag = document.querySelector(".days"),
    currentDate = document.querySelector(".current-date"),
    prevNextIcon = document.querySelectorAll(".icons span");

let date = new Date(),
    currYear = date.getFullYear(),
    currMonth = date.getMonth();

const months = ["Януари", "Февруари", "Март", "Април", "Май", "Юни", "Юли",
    "Август", "Септември", "Октомври", "Ноември", "Декември"];

const renderCalendar = () => {
    let firstDayofMonth = new Date(currYear, currMonth, 1).getDay(),
        lastDateofMonth = new Date(currYear, currMonth + 1, 0).getDate(),
        lastDayofMonth = new Date(currYear, currMonth, lastDateofMonth).getDay(),
        lastDateofLastMonth = new Date(currYear, currMonth, 0).getDate();
    let liTag = "";

    // Generating the previous month's dates
    for (let i = firstDayofMonth; i > 0; i--) {
        liTag += `<li class="inactive">${lastDateofLastMonth - i + 1}</li>`;
    }

    // Generating the current month's dates
    for (let i = 1; i <= lastDateofMonth; i++) {
        let isToday = i === date.getDate() && currMonth === new Date().getMonth()
            && currYear === new Date().getFullYear() ? "active" : "";
        liTag += `<li class="${isToday} ${isPastDate(i) ? 'inactive' : ''}">${i}</li>`;
    }

    // Generating the next month's dates
    for (let i = lastDayofMonth; i < 6; i++) {
        liTag += `<li class="inactive">${i - lastDayofMonth + 1}</li>`
    }

    currentDate.innerText = `${months[currMonth]} ${currYear}`;
    daysTag.innerHTML = liTag;

    // Adding event listener to each day
    const dayElements = document.querySelectorAll('.days li:not(.inactive)');
    dayElements.forEach(day => {
        day.addEventListener('click', () => {
            // Remove 'active' class from any previously selected date
            dayElements.forEach(d => d.classList.remove('active'));
            // Add 'active' class to the clicked date
            day.classList.add('active');
        });
    });
}

const isPastDate = (day) => {
    const today = new Date();
    const selectedDate = new Date(currYear, currMonth, day);

    return selectedDate < today.setHours(0, 0, 0, 0);
}

renderCalendar();

prevNextIcon.forEach(icon => {
    icon.addEventListener("click", () => {
        currMonth = icon.id === "prev" ? currMonth - 1 : currMonth + 1;

        if (currMonth < 0 || currMonth > 11) {
            date = new Date(currYear, currMonth, new Date().getDate());
            currYear = date.getFullYear();
            currMonth = date.getMonth();
        } else {
            date = new Date();
        }
        renderCalendar();
    });
});

