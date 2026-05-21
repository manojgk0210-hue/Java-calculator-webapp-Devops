const APP_CONTEXT = window.location.pathname.replace(/\/(?:index\.html)?$/, "");
const API_BASE = `${APP_CONTEXT}/api/v1/calculator`;

const form = document.querySelector("#calculator-form");
const resultValue = document.querySelector("#result-value");
const resultMessage = document.querySelector("#result-message");
const serviceStatus = document.querySelector("#service-status");
const operationButtons = document.querySelectorAll("[data-operation]");

async function checkHealth() {
    try {
        const response = await fetch(`${API_BASE}/health`);
        if (!response.ok) {
            throw new Error("Service unavailable");
        }

        serviceStatus.textContent = "Online";
        serviceStatus.classList.add("online");
    } catch (error) {
        serviceStatus.textContent = "Offline";
        serviceStatus.classList.remove("online");
    }
}

function getNumber(id) {
    const value = document.querySelector(id).value;
    return value === "" ? null : Number(value);
}

function buildRequest(operation) {
    if (operation === "sqrt") {
        return {
            endpoint: "sqrt",
            body: {
                number: getNumber("#number1")
            }
        };
    }

    return {
        endpoint: operation,
        body: {
            number1: getNumber("#number1"),
            number2: getNumber("#number2")
        }
    };
}

function setLoading(isLoading) {
    operationButtons.forEach((button) => {
        button.disabled = isLoading;
    });
}

function showSuccess(data) {
    resultValue.textContent = data.result;
    resultMessage.textContent = data.message || "Operation completed successfully";
    resultMessage.classList.remove("error");
}

function showError(data) {
    resultValue.textContent = "Error";
    resultMessage.textContent = data?.errors?.join(", ") || data?.message || "Something went wrong";
    resultMessage.classList.add("error");
}

async function calculate(operation) {
    const request = buildRequest(operation);
    setLoading(true);

    try {
        const response = await fetch(`${API_BASE}/${request.endpoint}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(request.body)
        });

        const data = await response.json();

        if (!response.ok) {
            showError(data);
            return;
        }

        showSuccess(data);
    } catch (error) {
        showError({ message: "Cannot connect to the calculator service" });
    } finally {
        setLoading(false);
    }
}

operationButtons.forEach((button) => {
    button.addEventListener("click", () => calculate(button.dataset.operation));
});

form.addEventListener("reset", () => {
    resultValue.textContent = "0";
    resultMessage.textContent = "Choose an operation to start.";
    resultMessage.classList.remove("error");
});

checkHealth();
