from jira import JIRA
import os

def fetch_jira_test_cases(jira_url, username, api_token, project_key, output_file):
    
    try:
        # Connect to Jira
        jira = JIRA(server=jira_url, basic_auth=(username, api_token))        
        # JQL query to fetch test cases
        jql_query = f'project = "{project_key}" AND issuetype = "Test" ORDER BY created DESC'
        issues = jira.search_issues(jql_query, maxResults=100)

        # Write test cases to the output file
        with open(output_file, 'w') as file:
            file.write(f"Test Cases for Project: {project_key}\n")
            file.write("=" * 50 + "\n\n")
            for issue in issues:
                file.write(f"Test Case ID: {issue.key}\n")
                file.write(f"Summary: {issue.fields.summary}\n")
                file.write(f"Description: {issue.fields.description or 'No description provided'}\n")
                file.write(f"Status: {issue.fields.status.name}\n")
                file.write("-" * 50 + "\n\n")

        print(f"Test cases exported successfully to {output_file}")

    except Exception as e:
        print(f"Error fetching test cases: {e}")


if __name__ == "__main__":
    # Jira configuration
    JIRA_URL = "https://qgenhub.atlassian.net"
    USERNAME = "sayantan.saha@outlook.in"
    API_TOKEN = "ATATT3xFfGF0Oim3mHVu61rsWpsJmNKn29njCUxGFgdtosJvzDyYKFfht_3ueWBDEEsfsgljBM7BIbopVJiNgCUCKuRBC_NSVHcjZpQieaFPrDY4Nin3AenN0zEgmRgflrmbPaQlNX_1vzy7sAVcsKG6qBYvSdoIPBF7QDNbfsEZzilZv25iwko=D2CE9697"
    PROJECT_KEY = "SCRUM"  # Replace with your Jira project key

    # Output file path
    OUTPUT_FILE = os.path.join(os.path.dirname("qGen-HUB/Utils/TestCase.js"), "jira_test_cases.txt")

    # Fetch and export test cases
    fetch_jira_test_cases(JIRA_URL, USERNAME, API_TOKEN, PROJECT_KEY, OUTPUT_FILE)